#include <iostream>
#include <string>
#include <stdlib.h>
#include <math.h>

using namespace std;

int prioridad(char c)
{
    if (c == '^')
    {
        return 30;
    }
    if (c == '*' or c == '/')
    {
        return 20;
    }
    if (c == '+' or c == '-')
    {
        return 10;
    }
    return 0;
}

bool esOperador(char c)
{
    return ((c >= ('0')) and (c <= ('9'))) ? false : true;
}

int elevar(int base, int exponenete)
{
    return (!exponenete) ? 1 : base * pow(base, exponenete - 1);
}

struct NodoArbol
{
    char caracter = 0;
    NodoArbol* izq = 0, * der = 0;
};

struct NodoPila
{
    NodoArbol* nodo = 0;

    NodoPila* siguiente = 0;

};

void insertar(NodoPila*& tope, NodoArbol* nodo)
{
    if (NodoPila* nuevo = (NodoPila*)malloc(sizeof(NodoPila)))
    {
        nuevo->nodo = nodo;
        nuevo->siguiente = (!tope) ? 0 : tope;
        tope = nuevo;
    }
    else
    {
        cout << "Nodo no insertado";
    }
}

NodoArbol* quitar(NodoPila*& tope)
{
    NodoArbol* nuevo = 0;
    if (nuevo = (NodoArbol*)malloc(sizeof(NodoArbol)))
    {
        nuevo->caracter = 0;
        nuevo->der = 0;
        nuevo->izq = 0;
    }
    if (tope)
    {
        nuevo = tope->nodo;
        tope = tope->siguiente;
    }
    return nuevo;
}

void crearArbol(NodoPila*& operadores, NodoPila*& expresiones, NodoArbol*& token, const std::string& cadena)
{
    for (int i = 0; i < cadena.length(); i++)
    {
        if (token = (NodoArbol*)malloc(sizeof(NodoArbol)))
        {
            token->caracter = cadena[i];
            token->izq = 0;
            token->der = 0;
            if (!esOperador(cadena[i]))
            {
                insertar(expresiones, token);
            }
            else
            {
                if (cadena[i] == '(')
                {
                    insertar(operadores, token);
                }
                if (cadena[i] == ')')
                {
                    while (operadores and operadores->nodo->caracter != '(')
                    {
                        if (token = quitar(operadores))
                        {
                            token->der = quitar(expresiones);
                            token->izq = quitar(expresiones);
                            insertar(expresiones, token);
                        }
                        quitar(operadores);
                    }
                    quitar(operadores);
                }
                if (cadena[i] != '(' and cadena[i] != ')')
                {
                    while (operadores and prioridad(cadena[i]) <= prioridad(operadores->nodo->caracter))
                    {
                        if (token = quitar(operadores))
                        {
                            token->der = quitar(expresiones);
                            token->izq = quitar(expresiones);
                            insertar(expresiones, token);
                        }
                    }
                    if (token = (NodoArbol*)malloc(sizeof(NodoArbol)))
                    {
                        token->caracter = cadena[i];
                    }

                    insertar(operadores, token);
                }
            }
        }
        else
        {
            cout << "Error no se pudo encontrar caracter = " << cadena[i] << endl;
        }
    }
    while (operadores)
    {
        if (token = quitar(operadores))
        {
            token->der = quitar(expresiones);
            token->izq = quitar(expresiones);
            insertar(expresiones, token);
        }
    }
    token = quitar(expresiones);
}

int evaluar(NodoArbol* raiz)
{
    int contador = 0;
    if (!esOperador(raiz->caracter))
    {
        return raiz->caracter - '0';
    }
    else
    {
        if (raiz->caracter == '^')
        {
            contador = contador + elevar(evaluar(raiz->izq), evaluar(raiz->der));
        }
        if (raiz->caracter == '*')
        {
            contador = contador + evaluar(raiz->izq) * evaluar(raiz->der);
        }
        if (raiz->caracter == '/')
        {
            contador = contador + evaluar(raiz->izq) / evaluar(raiz->der);
        }
        if (raiz->caracter == '+')
        {
            contador = contador + evaluar(raiz->izq) + evaluar(raiz->der);
        }
        if (raiz->caracter == '-')
        {
            contador = contador + evaluar(raiz->izq) - evaluar(raiz->der);
        }
    }
    return contador;
}

void mostrarArbol(NodoArbol*& arbol, int contador)
{
    if (arbol == NULL)
    {
        return;
    }
    else
    {
        mostrarArbol(arbol->der, contador + 1);
        for (int i = 0; i < contador; i++)
        {
            cout << "   ";
        }
        cout << arbol->caracter << endl;
        mostrarArbol(arbol->izq, contador + 1);
    }
}

int main()
{
    NodoPila* operadores = 0, * expresiones = 0;
    NodoArbol* token = 0;
    string cadena;
    int menu = 0;
    while (menu != 2)
    {
        cout << "ingrese una opcion \n1.-Calcular\n2.salir\n";
        cin >> menu;
        switch (menu)
        {
        case 1:
            cout << "ingrese una expresion: ";
            cin.ignore();
            getline(cin, cadena);

            crearArbol(operadores, expresiones, token, cadena);
            
            cout << "Calculo de arbol = " << evaluar(token) << endl;
            mostrarArbol(token, 0);
            break;
        }
    }
}