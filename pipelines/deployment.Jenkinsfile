pipeline { 
    agent any 
    stages { 
        stage('Git Checkout') { 
            steps { 
                script { 
                    git branch: 'main', 
                        credentialsId: 'git-PAT', // Provide your credentials ID
                        url: 'https://github.com/sanky-003/optit-lab-service.git' // Provide your Git repository URL
                } 
            } 
        }
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Assuming your all Kubernetes manifest files YAML is in the kubernetes directory of your repository
                    sh 'kubectl apply -f kubernetes/service.yml'
                    sh 'kubectl apply -f kubernetes/deployment.yml'
                }
            }
        }
    }
}