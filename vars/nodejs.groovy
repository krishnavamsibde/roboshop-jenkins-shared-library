def call(){
    env.EXTRA_OPTS=""
    node(){

        common.pipelineInit()
        stage('Download Dependencies') {
            sh '''
                ls -ltr
               npm install
               '''
        }

        common.codeChecks()

        if (env.BRANCH_NAME == env.TAG_NAME){
            common.publishArtifacts()
            common.publishAMI()
        }

    }

}