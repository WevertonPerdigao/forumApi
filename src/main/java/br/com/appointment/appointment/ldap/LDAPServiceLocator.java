package br.com.appointment.appointment.ldap;


import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

/**
 *  * Classe responsavel por localizar um contexto de diretório LDAP
 *  
 */
public class LDAPServiceLocator {

    protected static LDAPServiceLocator instance;

    private LDAPServiceLocator() {
        super();
    }


    /**
     *     * Obtem a mesma instancia de LDAPServiceLocator para todas as chamadas
     *      * (Classe singleton)
     *      *
     *      * @return um objeto LDAPServiceLocator
     *      
     */
    public static LDAPServiceLocator getInstance() {
        if (instance == null) {
            instance = new LDAPServiceLocator();
        }
        return instance;
    }


    public DirContext getContext() {
        Hashtable env = new Hashtable();
// Especifica a fabrica de INITIAL CONTEXT
        env.put(Context.INITIAL_CONTEXT_FACTORY, LDAPParametrosConfig.INITIAL_CTX);
// Especifica o IP/Nome e a porta do servidor LDAP
        env.put(Context.PROVIDER_URL, LDAPParametrosConfig.PROVIDER_URL);
// As linhas abaixo são usadas quando o servidor LDAP não permite busca como anonymous
//        env.put(Context.SECURITY_AUTHENTICATION, "simple");// simple==>usuario e senha
//        env.put(Context.SECURITY_PRINCIPAL, "uid=itbam,ou=system");
//        env.put(Context.SECURITY_CREDENTIALS, "Itbam@2019");
        DirContext ctx = null;
//        NamingEnumeration results = null;
        try {
// Obtem um Initial Context
            ctx = new InitialDirContext(env);
            System.out.println(ctx.toString());

//            SearchControls controls = new SearchControls();
//            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
//            results = ctx.search("", "(objectclass=users)", controls);
//            while (results.hasMore()) {
//                SearchResult searchResult = (SearchResult) results.next();
//                Attributes attributes = searchResult.getAttributes();
//                Attribute attr = attributes.get("cn");
//                String cn = (String) attr.get();
//                System.out.println(" Person Common Name = " + cn);
//            }


        } catch (NamingException e) {
            System.out.println("Não foi possivel obter um contexto LDAP");
            e.printStackTrace();
        }
        return ctx;
    }
}