stage('Git Checkout') {
    steps {
        script {
            def gitCheckout = load 'pipeline-scripts/gitCheckout.groovy'
            println "Git Checkout script loaded successfully"
            println "Branch Name: ${params.BRANCH_NAME}, Git URL: ${params.GIT_URL}"
            gitCheckout(params.BRANCH_NAME, params.GIT_URL, 'git-PAT')
        }
    }
}
