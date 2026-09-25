# Spec DevOps 02: Despliegue en AWS EC2 con GitHub Actions

## 1. Pipeline CI/CD (`.github/workflows/deploy.yml`)

```yaml
name: Deploy Dockerized App to AWS EC2

on:
  push:
    branches: [ "main" ]

jobs:
  deploy:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout Code
        uses: actions/checkout@v3

      - name: Deploy via SSH to AWS EC2
        uses: appleboy/ssh-action@v0.1.10
        with:
          host: ${{ secrets.EC2_HOST }}
          username: ${{ secrets.EC2_USERNAME }}
          key: ${{ secrets.EC2_SSH_KEY }}
          script: |
            cd /home/ubuntu/parcial_1 || git clone ${{ secrets.REPO_URL }} /home/ubuntu/parcial_1
            cd /home/ubuntu/parcial_1
            git pull origin main
            docker compose down
            docker compose up -d --build
            docker image prune -f
```
