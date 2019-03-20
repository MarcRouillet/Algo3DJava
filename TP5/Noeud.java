package TP5;
import java.util.Vector;


/**
 * La classe noeud est une classe abstraite en amont de la hi�rarchie de classe de notre graph de scene. 
 * Sa fonction principale est de porter la structure d'un arbre du graph de sc�ne.
 * Un noeud peut avoir plusieurs enfants et a un seul parent.
 * Seul le noeud d'origine n'a pas de parent.
 *
 * @author Alexis Heloir
 * @version 20/03/2019
 */
public class Noeud
{
    //Un noeud peut avoir plusieurs enfants
    Vector<Noeud> m_enfants;
    
    //Un oeud a un seul parent
    Noeud m_parent;    
    
    
    /**
     * Le constructeur par d�faut de la classe Noeud
     */
    public Noeud(Noeud _parent)
    {
        m_parent = _parent;
    }
}
