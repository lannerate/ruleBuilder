package com.flagleader.builder.dialogs.e;

import com.flagleader.manager.dialog.d.c;
import java.util.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class z extends A
{
  private Button b;

  public z(Shell paramShell, List paramList)
  {
    super(paramShell, new c(null, paramList));
  }

  public z(Shell paramShell, c paramc)
  {
    super(paramShell, paramc);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.Recover"));
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    this.b = new Button(localComposite, 32);
    this.b.setText(a("delete.Recover"));
    return localComposite;
  }

  protected void okPressed()
  {
    ((c)this.a).a(this.b.getSelection());
    super.okPressed();
  }

  public boolean a()
  {
    return ((c)this.a).a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.z
 * JD-Core Version:    0.6.0
 */