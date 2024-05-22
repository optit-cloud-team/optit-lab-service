def call(String branch, String gitUrl, String credentialsId) {
    git branch: branch,
        credentialsId: credentialsId,
        url: gitUrl
}
