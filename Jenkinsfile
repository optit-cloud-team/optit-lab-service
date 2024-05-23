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
                    if (dsl != null) {
                        dsl.gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'bkgit')
                    } else {
                        error "Failed to load dsl_script.groovy"
                    }
                }
            }
        }
        stage('Build with Gradle') {
            steps {
                script {
                    def dsl = load 'dsl_script.groovy'
                    if (dsl != null) {
                        dsl.buildWithGradle()
                    } else {
                        error "Failed to load dsl_script.groovy"
                    }
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    def dsl = load 'dsl_script.groovy'
                    if (dsl != null) {
                        dsl.dockerBuild(params.DOCKER_IMAGE_NAME)
                    } else {
                        error "Failed to load dsl_script.groovy"
                    }
                }
            }
        }
        stage('Docker Publish') {
            steps {
                script {
                    def dsl = load 'dsl_script.groovy'
                    if (dsl != null) {
                        dsl.dockerPublish(params.DOCKER_IMAGE_NAME, params.DOCKER_REPO, 'bkdockerid')
                    } else {
                        error "Failed to load dsl_script.groovy"
                    }
                }
            }
        }
    }
}
