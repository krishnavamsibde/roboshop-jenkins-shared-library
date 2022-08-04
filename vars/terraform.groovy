def call() {
    node {
        properties([
                parameters([
                        choice(choices: ['dev', 'prod'],  description: "Choose Environment", name: "ENV"),
                ])
        ])
        ansiColor('xterm'){

            stage('Code Checkout') {
                    sh 'find .'
                    git branch: 'main', url: 'https://github.com/krishnavamsi7616/roboshop-terraform-mutable.git'
                }

        stage('Terraform INIT') {
            sh 'terraform init -backend-config=env/${ENV}-backend.tfvars'
        }

        stage('Terraform Plan'){
            sh 'terraform plan -var-file=env/${ENV}.tfvars'
        }

        stage('Terraform Apply'){
            sh 'terraform apply -auto-approve -var-file=env/${ENV}.tfvars'
        }
    }
    }
}