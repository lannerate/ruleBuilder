package com.flagleader.builder.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.f.aW;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.rlm.value.SheetWhere;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class H extends r
{
  private SheetWhere a;
  private Text b;
  private BuilderManager c;

  private H(Shell paramShell)
  {
    super(paramShell);
  }

  public H(Shell paramShell, BuilderManager paramBuilderManager, SheetWhere paramSheetWhere)
  {
    this(paramShell);
    this.c = paramBuilderManager;
    this.a = paramSheetWhere;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    super.setMessage(a("title.SheetWhereValueDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    if (this.a == null)
      return localComposite1;
    localComposite1.setLayout(a(1));
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 100));
    c(localComposite2);
    return localComposite1;
  }

  protected void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setBackground(h.d);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    new aW(this.a, localComposite, this.c.getRuleEditor()).update();
  }

  protected void d(Composite paramComposite)
  {
  }

  protected void okPressed()
  {
    close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.H
 * JD-Core Version:    0.6.0
 */