pipeline {
    agent any
    
    stages {
        stage('Load DSL Script') {
            steps {
                script {
                    // Load DSL script
                   def dslScriptContent = load('dsl_script.groovy').getContent()
echo dslScriptContent

                }
            }
        }
    }
}
