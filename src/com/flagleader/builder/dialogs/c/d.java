package com.flagleader.builder.dialogs.c;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class d extends r
{
  protected Text a;
  protected Text b;
  protected Text c;
  private String d;
  private String e;
  private String f;

  public d(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.ExcelBookDialog"));
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    Group localGroup = new Group(localComposite, 0);
    localGroup.setLayoutData(a(500, 150));
    localGroup.setLayout(new GridLayout());
    c(localGroup);
    d(localGroup);
    return localComposite;
  }

  private void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(2));
    a(localComposite, a("displayName.ExcelBookDialog")).setLayoutData(b(80));
    this.a = b(localComposite, 2048);
    this.a.setLayoutData(b(340));
    this.a.setText(a("defaultDisName.ExcelBookDialog"));
    a(localComposite, a("bookName.ExcelBookDialog")).setLayoutData(b(80));
    this.b = b(localComposite, 2048);
    this.b.setLayoutData(b(340));
    this.b.setText("excel");
  }

  private void d(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(3));
    a(localComposite, a("xslFile.ExcelBookDialog")).setLayoutData(b(80));
    this.c = b(localComposite, 67584);
    this.c.setLayoutData(b(300));
    Button localButton = new Button(localComposite, 8);
    localButton.setText(ResourceTools.getMessage("browse"));
    localButton.addSelectionListener(new e(this));
  }

  protected void okPressed()
  {
    this.e = this.b.getText();
    this.d = this.a.getText();
    this.f = this.c.getText();
    super.okPressed();
  }

  public String a()
  {
    return this.d;
  }

  public String b()
  {
    return this.f;
  }

  public String c()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.c.d
 * JD-Core Version:    0.6.0
 */