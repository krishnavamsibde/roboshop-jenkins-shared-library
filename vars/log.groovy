def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}


//def call() {
//    pipeline {
//        agent any
//        stages {
//            stage('One') {
//                steps {
//                    sh 'echo One - ${COMPONENT}'
//                }
//            }
//            stage('Two') {
//                steps {
//                    sh 'echo Two'
//                }
//            }
//        }
//
//    }
//}

def call(){
    node() {
        stage('One'){
            sh 'echo One -  ${COMPONENT}'
        }

        stage('Two'){
            sh 'echo Two -  ${COMPONENT}'
        }
    }
}