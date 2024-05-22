pipeline {
    agent any
    
    stages {
        stage('Load DSL Script') {
            steps {
                script {
                    // Load DSL script
                    def dslScript = load('dsl_script.groovy')
                    
                    // Call DSL methods
                    dslScript.gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'git-PAT')
                    dslScript.buildWithGradle()
                    dslScript.dockerBuild(params.DOCKER_IMAGE_NAME)
                    dslScript.dockerPublish(params.DOCKER_IMAGE_NAME, params.DOCKER_REPO, 'bkdockerid')
                }
            }
        }
    }
}
