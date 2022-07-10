def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}


def call() {
    pipeline {
        agent any
        stages {
            stage('One') {
                steps {
                    sh 'echo One - ${COMPONENT}'
                }
            }
            stage('Two') {
                steps {
                    sh 'echo Two'
                }
            }
        }

    }
}