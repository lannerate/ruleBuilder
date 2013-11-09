package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.dialogs.r;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class v extends r
{
  private Text a;
  private String b = "";

  public v(String paramString, Shell paramShell)
  {
    super(paramShell);
    this.b = paramString;
  }

  public Control createDialogArea(Composite paramComposite)
  {
    setTitle(a("create_new_project"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    localComposite1.setLayout(new GridLayout());
    Composite localComposite2 = new Composite(localComposite1, 0);
    c(localComposite2);
    b(localComposite1);
    return localComposite1;
  }

  private void c(Composite paramComposite)
  {
    paramComposite.setLayout(a(2));
    a(paramComposite).setText(a("project_name"));
    this.a = a(paramComposite, 2048, 350, 15);
  }

  public String a()
  {
    return this.b;
  }

  protected void okPressed()
  {
    if (this.a.getText().length() == 0)
      return;
    this.b = this.a.getText();
    super.okPressed();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.v
 * JD-Core Version:    0.6.0
 */