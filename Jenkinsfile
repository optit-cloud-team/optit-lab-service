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
                    gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'git-PAT')
                }
            }
        }
        stage('Build with Gradle') {
            steps {
                script {
                    buildWithGradle()
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    dockerBuild(params.DOCKER_IMAGE_NAME)
                }
            }
        }
        stage('Docker Publish') {
            steps {
                script {
                    dockerPublish(params.DOCKER_IMAGE_NAME, params.DOCKER_REPO, 'bkdockerid')
                }
            }
        }
    }
}

// Include DSL script
def gitCheckout = load('dsl_script.groovy')
def buildWithGradle = load('dsl_script.groovy')
def dockerBuild = load('dsl_script.groovy')
def dockerPublish = load('dsl_script.groovy')
