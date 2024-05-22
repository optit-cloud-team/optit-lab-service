pipeline {
    agent any

    // Load DSL script
    options {
        skipDefaultCheckout(true) // Skip default checkout since we're using custom DSL
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    def dslScript = load('dsl_script.groovy')
                    dslScript.gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'git-PAT')
                }
            }
        }
        stage('Build with Gradle') {
            steps {
                script {
                    def dslScript = load('dsl_script.groovy')
                    dslScript.buildWithGradle()
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    def dslScript = load('dsl_script.groovy')
                    dslScript.dockerBuild(params.DOCKER_IMAGE_NAME)
                }
            }
        }
        stage('Docker Publish') {
            steps {
                script {
                    def dslScript = load('dsl_script.groovy')
                    dslScript.dockerPublish(params.DOCKER_IMAGE_NAME, params.DOCKER_REPO, 'bkdockerid')
                }
            }
        }
    }
}
