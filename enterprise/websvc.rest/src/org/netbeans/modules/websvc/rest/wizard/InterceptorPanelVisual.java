/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.websvc.rest.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.openide.WizardDescriptor;
import org.openide.util.NbBundle;

/**
 *
 * @author den
 */
public class InterceptorPanelVisual extends javax.swing.JPanel {

    /**
     * @param myDescriptor
     */
    public InterceptorPanelVisual( WizardDescriptor myDescriptor ) {
        listeners = new CopyOnWriteArrayList<ChangeListener>();
        initComponents();
        
        ActionListener listener = new ActionListener() {
            
            @Override
            public void actionPerformed( ActionEvent arg0 ) {
                fireChangeEvent();
            }
        };
        reader.addActionListener(listener);
        writer.addActionListener(listener);
    }
    
    void addChangeListener( ChangeListener listener ) {
        listeners.add(listener);        
    }

    String getError() {
        if ( !reader.isSelected() && !writer.isSelected()){
            return NbBundle.getMessage(InterceptorPanelVisual.class, 
                    "ERR_NoInterceptorType");
        }
        return null;
    }

    void readSettings( WizardDescriptor descriptor ) {
    }

    void removeChangeListener( ChangeListener listener ) {
        listeners.remove(listener);        
    }

    void storeSettings( WizardDescriptor descriptor ) {
        descriptor.putProperty(InterceptorPanel.READER, reader.isSelected());
        descriptor.putProperty(InterceptorPanel.WRITER, writer.isSelected());
    }
    
    private void fireChangeEvent(){
        ChangeEvent event = new ChangeEvent(this);
        for(ChangeListener listener :listeners ){
            listener.stateChanged(event);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        type = new javax.swing.JLabel();
        typesPanel = new javax.swing.JPanel();
        reader = new javax.swing.JCheckBox();
        writer = new javax.swing.JCheckBox();

        type.setLabelFor(typesPanel);
        org.openide.awt.Mnemonics.setLocalizedText(type, org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "LBL_InterceptorType")); // NOI18N

        typesPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.openide.awt.Mnemonics.setLocalizedText(reader, org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "LBL_ReaderInterceptor")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(writer, org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "LBL_WriterInterceptor")); // NOI18N

        javax.swing.GroupLayout typesPanelLayout = new javax.swing.GroupLayout(typesPanel);
        typesPanel.setLayout(typesPanelLayout);
        typesPanelLayout.setHorizontalGroup(
            typesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reader)
                    .addComponent(writer))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        typesPanelLayout.setVerticalGroup(
            typesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(writer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reader.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "ACSN_ReaderInterceptor")); // NOI18N
        reader.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "ACSD_ReaderInterceptor")); // NOI18N
        writer.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "ACSN_WriterInterceptor")); // NOI18N
        writer.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "ACSD_WriterInterceptor")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(type)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(typesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(type)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        type.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "ACSN_Interceptors")); // NOI18N
        type.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(InterceptorPanelVisual.class, "ACSD_Interceptors")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox reader;
    private javax.swing.JLabel type;
    private javax.swing.JPanel typesPanel;
    private javax.swing.JCheckBox writer;
    // End of variables declaration//GEN-END:variables
    
    private List<ChangeListener> listeners;
    
}
