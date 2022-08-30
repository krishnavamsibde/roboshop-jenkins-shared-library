def call(){
    env.EXTRA_OPTS=""
    node(){

        common.pipelineInit()
        if( env.BRANCH_NAME == env.TAG_NAME )
        {
            sh 'git checkout ${TAG_NAME}'
        }
        common.codeChecks()

        if (env.BRANCH_NAME == env.TAG_NAME){
            common.publishLocalArtifacts()
            common.publishAMI()
        }
    }

}