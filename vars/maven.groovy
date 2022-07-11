def call(){
    node(){

        common.pipelineInit()
        stage('Build Package') {
            sh '''
                mvn clean package
               '''
        }
        if (env.BRANCH_NAME == env.TAG_NAME){
            common.publishArtifacts()
        }
    }

}