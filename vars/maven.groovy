def call(){
    env.EXTRA_OPTS="-Dsonar.java.binaries=./target"
    node(){

        common.pipelineInit()

        if (env.BRANCH_NAME == env.TAG_NAME)
        {
            sh 'git checkout ${TAG_NAME}'
        }
        stage('Build Package') {
            sh '''
                mvn clean package
               '''
        }

        common.codeChecks()

        if (env.BRANCH_NAME == env.TAG_NAME){
           // common.publishArtifacts()
            common.publishLocalArtifacts()
            common.publishAMI()
        }
    }

}