package br.com.appointment.appointment.ldap;

import javax.naming.NamingEnumeration;
import javax.naming.directory.*;

/**
 * Classe de teste que efetua um busca simples em um repositório LDAP
 */
public class TesteLDAP {
    public static void main(String[] args) {
// ////////////////////
// Inicialmente há apenas esse usuario
        String login = "weverton.perdigao";
        String senha = "itbam@15";
// ///////////
        DirContext ctx = LDAPServiceLocator.getInstance().getContext();
        System.out.println("passou contexto");


        Attributes matchAttrs = new BasicAttributes(false);
// Array de atributos que deseja retornar do LDAP
        String[] atributosRetorno = new String[]{"mail", "cn", "userPassword"};
// Parametros de busca
        matchAttrs.put(new BasicAttribute("uid", login));
        matchAttrs.put(new BasicAttribute("userPassword", senha));
        System.out.println("Buscando...");
        try {
// Efetua a busca
            NamingEnumeration resultado = ctx.search(
                    LDAPParametrosConfig.SEARCHBASE, matchAttrs,
                    atributosRetorno);
            System.out.println(resultado);
// Exibindo o resultado, se houver
            while (resultado.hasMore()) {
                SearchResult sr = (SearchResult) resultado.next();
// Obtem os atributos
                Attributes atributos = sr.getAttributes();
                for (NamingEnumeration todosAtributos = atributos.getAll(); todosAtributos
                        .hasMore(); ) {
                    Attribute attrib = (Attribute) todosAtributos.next();
                    String nomeAtributo = attrib.getID();
                    System.out.println("Atributo:" + nomeAtributo);
// Exibe todos os valores do atributo
                    for (NamingEnumeration e = attrib.getAll(); e.hasMore(); ) {
                        System.out.println("\tvalor:" + e.next());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Busca finalizada.");
    }
}