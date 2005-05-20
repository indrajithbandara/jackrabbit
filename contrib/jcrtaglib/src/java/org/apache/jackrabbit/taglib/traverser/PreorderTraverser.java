/*
 * Copyright 2004-2005 The Apache Software Foundation or its licensors,
 *                     as applicable.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.taglib.traverser;

import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Preorder traverse strategy 
 * 
 * @author <a href="mailto:edgarpoce@gmail.com">Edgar Poce</a>
 */
public class PreorderTraverser extends AbstractTraverser
{
    
    /**
     * Preorder traversal
     * 
     * @param node
     * @throws RepositoryException
     */
    private void preorder(Node node) throws RepositoryException
    {
        visit(node);
        try
        {
            Iterator iter = this.getChildren(node);
            while (iter.hasNext())
            {
                this.preorder((Node) iter.next());
            }
        } catch (DepthExceededException e)
        {
            // Do nothing
        }
    }
    
    /**
     * Traverse the node children tree
     * @throws RepositoryException
     */
    protected void internalTraverse() throws RepositoryException
    {
        this.preorder(this.node);
    }
}
