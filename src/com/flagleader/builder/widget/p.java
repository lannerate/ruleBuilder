package com.flagleader.builder.widget;

import com.flagleader.builder.BuilderManager;
import java.util.Hashtable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class p extends B
{
  private Text e;
  private BuilderManager f;

  public p(BuilderManager paramBuilderManager)
  {
    this.f = paramBuilderManager;
    addObserver(this.f.getMenuAndToolBar());
  }

  public p()
  {
  }

  public Text a(Composite paramComposite, int paramInt)
  {
    this.e = new Text(paramComposite, paramInt);
    this.e.addFocusListener(new q(this));
    this.e.addKeyListener(new r(this));
    return this.e;
  }

  public void restoreState(Hashtable paramHashtable)
  {
    Object localObject = paramHashtable.get("Text");
    if ((localObject != null) && (!this.e.isDisposed()))
      this.e.setText(localObject.toString());
  }

  public void storeState(Hashtable paramHashtable)
  {
    paramHashtable.put("Text", this.e.getText());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.p
 * JD-Core Version:    0.6.0
 */