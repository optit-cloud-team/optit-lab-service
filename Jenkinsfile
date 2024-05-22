pipeline {
    agent any
    
    stages {
        stage('Load DSL Script') {
            steps {
                script {
                    // Load DSL script
                    def dslScript = loadScript('dsl_script.groovy')
                    
                    // Print content of DSL script for debugging
                    echo dslScript
                }
            }
        }
    }
}
