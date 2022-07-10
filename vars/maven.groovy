def call(){
    node(){

        common.pipelineInit()
        stage('Build Package') {
            sh '''
                mvn clean package
               '''
        }

    }

}