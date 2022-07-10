def pipelineInit(){
    stage('Intiate Repo'){
        sh 'rm -rf *'
        git branch: 'main', url: "https://github.com/krishnavamsi7616/${COMPONENT}.git"
    }
}


def publishArtifacts() {
    stage("Prepare Artifacts") {
        sh """
            zip -r ${COMPONENT}.zip node_modules server.js
        """
    }
}