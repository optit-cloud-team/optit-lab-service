pipeline {
    agent any

    parameters {
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build from')
        string(name: 'GIT_URL', defaultValue: 'https://github.com/optit-cloud-team/optit-lab-service.git', description: 'Git repository URL')
        string(name: 'DOCKER_IMAGE_NAME', defaultValue: 'optit-lab-service', description: 'Docker image name')
        string(name: 'DOCKER_REPO', defaultValue: 'bharathoptdocker', description: 'Docker repository')
    }

    stages {
        stage('Git Checkout') {
            steps {
                script {
                    def dsl = load 'dsl_script.groovy'
                    dsl.gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'git-PAT')
                }
            }
        }
        stage('Build with Gradle') {
            steps {
                script {
                    def dsl = load 'dsl_script.groovy'
                    dsl.buildWithGradle()
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    def dsl = load 'dsl_script.groovy'
                    dsl.dockerBuild(params.DOCKER_IMAGE_NAME)
                }
            }
        }
        stage('Docker Publish') {
            steps {
                script {
                    def dsl = load 'dsl_script.groovy'
                    dsl.dockerPublish(params.DOCKER_IMAGE_NAME, params.DOCKER_REPO, 'bkdockerid')
                }
            }
        }
    }
}
