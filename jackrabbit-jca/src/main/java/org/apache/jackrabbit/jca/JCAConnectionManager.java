/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.jca;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;

/**
 * This class implements the default connection manager.
 */
public final class JCAConnectionManager implements ConnectionManager {

	private static final long serialVersionUID = 1479445982219812432L;

	/**
     * The method allocateConnection gets called by the resource adapter's
     * connection factory instance.
     */
    public Object allocateConnection(ManagedConnectionFactory mcf, ConnectionRequestInfo cri)
            throws ResourceException {
        ManagedConnection mc = mcf.createManagedConnection(null, cri);
        return mc.getConnection(null, cri);
    }
}
