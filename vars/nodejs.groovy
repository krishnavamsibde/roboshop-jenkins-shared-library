def call(){
    node(){
        stage('Download Dependencies') {
            sh '''
                ls -ltr
               npm install
               '''
        }

    }

}