def call(){
    node(){

        common.pipelineInit()
        stage('Build Package') {
            sh '''
                mvn clean package
               '''
        }

        common.codeChecks()
        
        if (env.BRANCH_NAME == env.TAG_NAME){
            common.publishArtifacts()
        }
    }

}