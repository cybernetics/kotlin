/*
 * Copyright 2010-2013 JetBrains s.r.o.
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

package org.jetbrains.jet.di;

import org.jetbrains.jet.lang.types.expressions.ExpressionTypingServices;
import org.jetbrains.jet.lang.resolve.calls.NeedSyntheticCallResolverExtension;
import org.jetbrains.jet.lang.PlatformToKotlinClassMap;
import com.intellij.openapi.project.Project;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptor;
import org.jetbrains.jet.lang.resolve.calls.CallExpressionResolver;
import org.jetbrains.jet.lang.resolve.calls.CallResolver;
import org.jetbrains.jet.lang.resolve.calls.ArgumentTypeResolver;
import org.jetbrains.jet.lang.resolve.TypeResolver;
import org.jetbrains.jet.lang.resolve.AnnotationResolver;
import org.jetbrains.jet.lang.resolve.DescriptorResolver;
import org.jetbrains.jet.lang.resolve.QualifiedExpressionResolver;
import org.jetbrains.jet.lang.resolve.calls.CandidateResolver;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.GenerateInjectors. DO NOT EDIT! */
public class InjectorForMacros {
    
    private final ExpressionTypingServices expressionTypingServices;
    private final NeedSyntheticCallResolverExtension needSyntheticCallResolverExtension;
    private final PlatformToKotlinClassMap platformToKotlinClassMap;
    private final Project project;
    private final ModuleDescriptor moduleDescriptor;
    private final CallExpressionResolver callExpressionResolver;
    private final CallResolver callResolver;
    private final ArgumentTypeResolver argumentTypeResolver;
    private final TypeResolver typeResolver;
    private final AnnotationResolver annotationResolver;
    private final DescriptorResolver descriptorResolver;
    private final QualifiedExpressionResolver qualifiedExpressionResolver;
    private final CandidateResolver candidateResolver;
    
    public InjectorForMacros(
        @NotNull Project project,
        @NotNull ModuleDescriptor moduleDescriptor
    ) {
        this.expressionTypingServices = new ExpressionTypingServices();
        this.needSyntheticCallResolverExtension = new NeedSyntheticCallResolverExtension();
        this.platformToKotlinClassMap = moduleDescriptor.getPlatformToKotlinClassMap();
        this.project = project;
        this.moduleDescriptor = moduleDescriptor;
        this.callExpressionResolver = new CallExpressionResolver();
        this.callResolver = new CallResolver();
        this.argumentTypeResolver = new ArgumentTypeResolver();
        this.typeResolver = new TypeResolver();
        this.annotationResolver = new AnnotationResolver();
        this.descriptorResolver = new DescriptorResolver();
        this.qualifiedExpressionResolver = new QualifiedExpressionResolver();
        this.candidateResolver = new CandidateResolver();

        this.expressionTypingServices.setCallExpressionResolver(callExpressionResolver);
        this.expressionTypingServices.setCallResolver(callResolver);
        this.expressionTypingServices.setDescriptorResolver(descriptorResolver);
        this.expressionTypingServices.setPlatformToKotlinClassMap(platformToKotlinClassMap);
        this.expressionTypingServices.setProject(project);
        this.expressionTypingServices.setTypeResolver(typeResolver);

        callExpressionResolver.setExpressionTypingServices(expressionTypingServices);

        callResolver.setArgumentTypeResolver(argumentTypeResolver);
        callResolver.setCandidateResolver(candidateResolver);
        callResolver.setExpressionTypingServices(expressionTypingServices);
        callResolver.setExtension(needSyntheticCallResolverExtension);
        callResolver.setTypeResolver(typeResolver);

        argumentTypeResolver.setExpressionTypingServices(expressionTypingServices);
        argumentTypeResolver.setTypeResolver(typeResolver);

        typeResolver.setAnnotationResolver(annotationResolver);
        typeResolver.setDescriptorResolver(descriptorResolver);
        typeResolver.setModuleDescriptor(moduleDescriptor);
        typeResolver.setQualifiedExpressionResolver(qualifiedExpressionResolver);

        annotationResolver.setCallResolver(callResolver);
        annotationResolver.setExpressionTypingServices(expressionTypingServices);

        descriptorResolver.setAnnotationResolver(annotationResolver);
        descriptorResolver.setExpressionTypingServices(expressionTypingServices);
        descriptorResolver.setTypeResolver(typeResolver);

        candidateResolver.setArgumentTypeResolver(argumentTypeResolver);

    }
    
    @PreDestroy
    public void destroy() {
    }
    
    public ExpressionTypingServices getExpressionTypingServices() {
        return this.expressionTypingServices;
    }
    
    public Project getProject() {
        return this.project;
    }
    
}
