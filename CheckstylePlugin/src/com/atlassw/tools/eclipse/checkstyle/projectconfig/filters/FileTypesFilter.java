//============================================================================
//
// Copyright (C) 2002-2004  David Schneider
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//============================================================================

package com.atlassw.tools.eclipse.checkstyle.projectconfig.filters;

import java.util.List;

import org.eclipse.core.resources.IResource;

/**
 * Filter that excludes all but some specifically defined file types from the
 * checks.
 * 
 * @author Lars K�dderitzsch
 */
public class FileTypesFilter extends AbstractFilter
{

    //
    // attributes
    //

    /** List containing the passing file types. */
    private List mFileTypes;

    //
    // attributes
    //

    /**
     * @see IFilter#accept(java.lang.Object)
     */
    public boolean accept(Object element)
    {
        boolean goesThrough = false;

        if (element instanceof IResource)
        {

            IResource resource = (IResource) element;
            int type = resource.getType();

            //java files go through
            goesThrough = (IResource.FILE == type)
                    && (mFileTypes.contains(resource.getFileExtension()));
        }
        return goesThrough;
    }

    /**
     * @see AbstractFilter#setFilterData(java.util.List)
     */
    public void setFilterData(List filterData)
    {
        mFileTypes = filterData;
    }
}