package br.com.appointment.appointment.ldap;


/**
 *  * Paramêtros de configuração do LDAP
 *  *
 *  
 */
public class LDAPParametrosConfig {

    /*
     * Implementação do Initial context para LDAP
     */
    public static final String INITIAL_CTX = "com.sun.jndi.ldap.LdapCtxFactory";
    /*
     * Servidor LDAP
     */
    public static final String PROVIDER_URL = "ldap://172.100.10.48:389/ou=system";

      /*
     * Base de busca
     */

    public static final String SEARCHBASE = "ou=system";


    //public static final String SEARCHBASE = "ou=*, dc=itbam, dc=org, dc=br";

    /*
     * Nome do usuário do admin
     */
    public static final String ADMIN_DN = "cn=admin, dc=ITBAM";
    /*
         * Senha
     */
    public static final String ADMIN_PW = "secreta";
    /*
     *  “top level” do diretório (base DN)
     */
    public static final String BASE_DN = "dc=ITBAM, dc=ORG, dc=BR";
}