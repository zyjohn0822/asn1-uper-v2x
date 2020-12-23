/*
 Copyright 2006-2011 Abdulla Abdurakhmanov (abdulla@latestbit.com)
 Original sources are available at www.latestbit.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.bn.metadata;

import java.lang.reflect.AnnotatedElement;

/**
 * @author zhangyong
 */
public abstract class ASN1Metadata implements IASN1Metadata {
    private String name;

    public ASN1Metadata() {

    }

    public ASN1Metadata(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParentAnnotated(AnnotatedElement parentAnnotated) {
    }
}

