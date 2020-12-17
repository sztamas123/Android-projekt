package com.example.restaurantapp.fragments.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/example/restaurantapp/fragments/list/ListFragmentDirections;", "", "()V", "ActionListFragmentToUpdateFragment", "Companion", "app_debug"})
public final class ListFragmentDirections {
    public static final com.example.restaurantapp.fragments.list.ListFragmentDirections.Companion Companion = null;
    
    private ListFragmentDirections() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/example/restaurantapp/fragments/list/ListFragmentDirections$ActionListFragmentToUpdateFragment;", "Landroidx/navigation/NavDirections;", "currentRestaurant", "Lcom/example/restaurantapp/model/Restaurant;", "(Lcom/example/restaurantapp/model/Restaurant;)V", "getCurrentRestaurant", "()Lcom/example/restaurantapp/model/Restaurant;", "component1", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "app_debug"})
    static final class ActionListFragmentToUpdateFragment implements androidx.navigation.NavDirections {
        @org.jetbrains.annotations.NotNull()
        private final com.example.restaurantapp.model.Restaurant currentRestaurant = null;
        
        @java.lang.Override()
        public int getActionId() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"CAST_NEVER_SUCCEEDS"})
        @java.lang.Override()
        public android.os.Bundle getArguments() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.restaurantapp.model.Restaurant getCurrentRestaurant() {
            return null;
        }
        
        public ActionListFragmentToUpdateFragment(@org.jetbrains.annotations.NotNull()
        com.example.restaurantapp.model.Restaurant currentRestaurant) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.restaurantapp.model.Restaurant component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.restaurantapp.fragments.list.ListFragmentDirections.ActionListFragmentToUpdateFragment copy(@org.jetbrains.annotations.NotNull()
        com.example.restaurantapp.model.Restaurant currentRestaurant) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2 = {"Lcom/example/restaurantapp/fragments/list/ListFragmentDirections$Companion;", "", "()V", "actionListFragmentToAddFragment", "Landroidx/navigation/NavDirections;", "actionListFragmentToAddProfileFragment", "actionListFragmentToProfileFragment", "actionListFragmentToUpdateFragment", "currentRestaurant", "Lcom/example/restaurantapp/model/Restaurant;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections actionListFragmentToAddFragment() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections actionListFragmentToUpdateFragment(@org.jetbrains.annotations.NotNull()
        com.example.restaurantapp.model.Restaurant currentRestaurant) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections actionListFragmentToProfileFragment() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections actionListFragmentToAddProfileFragment() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}