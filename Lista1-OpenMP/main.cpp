#include <omp.h>
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

const int TAM = 200;

void imprime_matriz(int mat[TAM][TAM]){
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            cout<<mat[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
}

int main(){

    double inicio,fim;
    int m1[TAM][TAM], m2[TAM][TAM], res[TAM][TAM];
    
    srand (time(NULL));
    for(int i=0; i<TAM; i++){
        for(int j=0; j<TAM; j++){
            m1[i][j] = rand()%10;
            m2[i][j] = rand()%10;
        }
    }

    int aux = 0;
    
    inicio = omp_get_wtime();
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            aux = 0;
            for (int k = 0; k < TAM; k++){
                aux = aux + m1[i][k]*m2[k][j];
            }
            res[i][j] = aux;
        }
    }
    fim = omp_get_wtime();
    double rs = fim-inicio;
    cout << "O tempo sequencial foi de: " << rs << " s.";
    
    inicio = omp_get_wtime();
    #pragma omp parallel for
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            aux = 0;
            for (int k = 0; k < TAM; k++){
                aux = aux + m1[i][k]*m2[k][j];
            }
            res[i][j] = aux;
        }
    }
    fim = omp_get_wtime();
    double rp = fim-inicio;
    cout << "\nO tempo paralelo foi de: " << rp << " s." << endl;

    return 0;
}