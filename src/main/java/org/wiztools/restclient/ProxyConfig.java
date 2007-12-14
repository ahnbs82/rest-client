/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.wiztools.restclient;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author schandran
 */
public final class ProxyConfig {

    // Singleton
    
    private static ProxyConfig _proxy;
    
    public static ProxyConfig getInstance(){
        if(_proxy == null){
            _proxy = new ProxyConfig();
        }
        return _proxy;
    }
    
    private ProxyConfig(){}
    
    // Lock to ensure consistency
    private Lock _lck = new ReentrantLock();
    
    public void acquire(){
        _lck.lock();
    }
    
    public void release(){
        _lck.unlock();
    }
    
    // Data
    
    private boolean enabled = false;
    private String host;
    private int port;
    private boolean authEnabled = false;
    private String username;
    private char[] password;

    public boolean isAuthEnabled() {
        return authEnabled;
    }

    public void setAuthEnabled(boolean authEnabled) {
        this.authEnabled = authEnabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
