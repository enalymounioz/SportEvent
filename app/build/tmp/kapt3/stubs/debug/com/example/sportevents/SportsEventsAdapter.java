package com.example.sportevents;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/sportevents/SportsEventsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "sportsEvents", "", "", "listener", "Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;", "(Ljava/util/List;Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "EventItemViewHolder", "ItemActionListener", "SportHeaderViewHolder", "app_debug"})
public final class SportsEventsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> sportsEvents = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.sportevents.SportsEventsAdapter.ItemActionListener listener = null;
    public static final int VIEW_TYPE_SPORT_HEADER = 1;
    public static final int VIEW_TYPE_EVENT_ITEM = 2;
    @org.jetbrains.annotations.NotNull
    public static final com.example.sportevents.SportsEventsAdapter.Companion Companion = null;
    
    public SportsEventsAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> sportsEvents, @org.jetbrains.annotations.NotNull
    com.example.sportevents.SportsEventsAdapter.ItemActionListener listener) {
        super();
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/sportevents/SportsEventsAdapter$Companion;", "", "()V", "VIEW_TYPE_EVENT_ITEM", "", "VIEW_TYPE_SPORT_HEADER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/sportevents/SportsEventsAdapter$EventItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;", "(Landroid/view/View;Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;)V", "countDown", "Landroid/widget/TextView;", "countDownTimer", "Landroid/os/CountDownTimer;", "getCountDownTimer", "()Landroid/os/CountDownTimer;", "setCountDownTimer", "(Landroid/os/CountDownTimer;)V", "currentEvent", "Lcom/example/sportevents/Event;", "getCurrentEvent", "()Lcom/example/sportevents/Event;", "setCurrentEvent", "(Lcom/example/sportevents/Event;)V", "eventName", "favoriteButton", "Landroid/widget/ImageButton;", "bind", "", "event", "app_debug"})
    public static final class EventItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.sportevents.SportsEventsAdapter.ItemActionListener listener = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView eventName = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageButton favoriteButton = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView countDown = null;
        @org.jetbrains.annotations.Nullable
        private android.os.CountDownTimer countDownTimer;
        @org.jetbrains.annotations.Nullable
        private com.example.sportevents.Event currentEvent;
        
        public EventItemViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView, @org.jetbrains.annotations.NotNull
        com.example.sportevents.SportsEventsAdapter.ItemActionListener listener) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.os.CountDownTimer getCountDownTimer() {
            return null;
        }
        
        public final void setCountDownTimer(@org.jetbrains.annotations.Nullable
        android.os.CountDownTimer p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.example.sportevents.Event getCurrentEvent() {
            return null;
        }
        
        public final void setCurrentEvent(@org.jetbrains.annotations.Nullable
        com.example.sportevents.Event p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.sportevents.Event event) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;", "", "onFavoriteToggle", "", "position", "", "onSportToggle", "app_debug"})
    public static abstract interface ItemActionListener {
        
        public abstract void onSportToggle(int position);
        
        public abstract void onFavoriteToggle(int position);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/sportevents/SportsEventsAdapter$SportHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;", "(Landroid/view/View;Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;)V", "sportName", "Landroid/widget/TextView;", "bind", "", "sport", "Lcom/example/sportevents/Sport;", "app_debug"})
    public static final class SportHeaderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.sportevents.SportsEventsAdapter.ItemActionListener listener = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView sportName = null;
        
        public SportHeaderViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView, @org.jetbrains.annotations.NotNull
        com.example.sportevents.SportsEventsAdapter.ItemActionListener listener) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.sportevents.Sport sport) {
        }
    }
}