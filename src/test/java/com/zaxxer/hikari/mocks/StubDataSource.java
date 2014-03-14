/*
 * Copyright (C) 2013 Brett Wooldridge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zaxxer.hikari.mocks;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 *
 * @author Brett Wooldridge
 */
public class StubDataSource implements DataSource
{
    private String user;
    private String password;
    private PrintWriter logWriter;

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    /** {@inheritDoc} */
    @Override
    public PrintWriter getLogWriter() throws SQLException
    {
        return logWriter;
    }

    /** {@inheritDoc} */
    @Override
    public void setLogWriter(PrintWriter out) throws SQLException
    {
        this.logWriter = out;
    }

    /** {@inheritDoc} */
    @Override
    public void setLoginTimeout(int seconds) throws SQLException
    {
    }

    /** {@inheritDoc} */
    @Override
    public int getLoginTimeout() throws SQLException
    {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public Connection getConnection() throws SQLException
    {
        return new StubConnection();
    }

    /** {@inheritDoc} */
    @Override
    public Connection getConnection(String username, String password) throws SQLException
    {
        return new StubConnection();
    }
}
