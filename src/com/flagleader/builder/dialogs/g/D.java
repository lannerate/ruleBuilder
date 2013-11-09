package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class D extends f
{
  private String c;
  private String d;
  protected Text a;
  protected Text b;
  private BuilderManager e;

  public D(BuilderManager paramBuilderManager, String paramString1, String paramString2)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = paramBuilderManager;
    this.c = paramString1;
    this.d = paramString2;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(b("title.TemplateTypeDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(240, 50));
    a(localComposite2, "pname.TemplateTypeDialog").setLayoutData(b(60));
    this.a = a(localComposite2, 2048);
    this.a.setLayoutData(b(160));
    a(localComposite2, "ptypeName.TemplateTypeDialog").setLayoutData(b(60));
    this.b = a(localComposite2, 67584);
    this.b.setLayoutData(b(160));
    this.b.setEchoChar('*');
    this.a.setText(this.c);
    this.b.setText(this.d);
    return localComposite1;
  }

  protected void okPressed()
  {
    this.c = this.a.getText();
    this.d = this.b.getText();
    super.okPressed();
  }

  public String a()
  {
    return this.c;
  }

  public String b()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.D
 * JD-Core Version:    0.6.0
 */