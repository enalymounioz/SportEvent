package com.example.sportevents;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/sportevents/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/sportevents/SportsEventsAdapter$ItemActionListener;", "()V", "adapter", "Lcom/example/sportevents/SportsEventsAdapter;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerViewSports", "Landroidx/recyclerview/widget/RecyclerView;", "textViewError", "Landroid/widget/TextView;", "viewModel", "Lcom/example/sportevents/SportsEventsViewModel;", "fetchData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFavoriteToggle", "position", "", "onSportToggle", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.sportevents.SportsEventsAdapter.ItemActionListener {
    private com.example.sportevents.SportsEventsViewModel viewModel;
    private com.example.sportevents.SportsEventsAdapter adapter;
    private androidx.recyclerview.widget.RecyclerView recyclerViewSports;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView textViewError;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onSportToggle(int position) {
    }
    
    @java.lang.Override
    public void onFavoriteToggle(int position) {
    }
    
    private final void fetchData() {
    }
}