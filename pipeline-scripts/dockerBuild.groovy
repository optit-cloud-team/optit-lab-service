def call(String imageName) {
    docker.build(imageName, ".") // Using parameter for Docker image name
}
