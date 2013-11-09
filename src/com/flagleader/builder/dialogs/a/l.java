package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.d.a;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class l extends f
{
  private Text c;
  private Table d;
  private String e;
  BuilderManager a;
  Envionment b;

  public l(BuilderManager paramBuilderManager, Envionment paramEnvionment, String paramString)
  {
    super(paramBuilderManager.getShell());
    this.e = paramString;
    this.a = paramBuilderManager;
    this.b = paramEnvionment;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(1));
    super.a(localComposite, "addClass.BusinessObjectEditor");
    this.c = b(localComposite, 2048, 410, 12);
    this.c.setText(this.e);
    if (this.e.length() > 0)
    {
      this.c.setSelection(this.e.length());
      a(this.c.getText());
    }
    else
    {
      a("");
    }
    this.c.addKeyListener(new m(this));
    this.d = new Table(localComposite, 67840);
    GridData localGridData = new GridData();
    localGridData.widthHint = 400;
    localGridData.heightHint = 400;
    this.d.setLayoutData(localGridData);
    this.d.addSelectionListener(new n(this));
    return localComposite;
  }

  private void a(String paramString)
  {
    o localo = new o(this, paramString);
    Display.getCurrent().timerExec(1, localo);
  }

  protected void okPressed()
  {
    this.e = this.c.getText();
    close();
  }

  public String a()
  {
    return this.e;
  }

  private Iterator b()
  {
    return this.b.getBomClassLoader().c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.l
 * JD-Core Version:    0.6.0
 */