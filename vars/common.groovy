def pipelineInit(){
    stage('Intiate Repo'){
        sh 'rm -rf *'
        git branch: 'main', url: "https://github.com/krishnavamsi7616/${COMPONENT}.git"
    }
}


def publishArtifacts() {
    stage("Prepare Artifacts") {
        if (env.APP_TYPE == "nodejs"){
        sh """
            zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js
        """
        }
    }
}