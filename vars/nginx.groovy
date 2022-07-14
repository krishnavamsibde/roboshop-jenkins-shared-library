def call() {
    env.EXTRA_OPTS={}
    node() {

        common.pipelineInit()

        if (env.BRANCH_NAME == env.TAG_NAME) {
            common.publishArtifacts()
        }
    }
}