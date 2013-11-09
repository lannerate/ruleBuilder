package com.flagleader.builder.dialogs.method;

import java.util.ResourceBundle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class a
{
  private static ResourceBundle d = ResourceBundle.getBundle("examples_addressbook");
  Shell a;
  String[] b;
  String[] c;

  public a(Shell paramShell)
  {
    this.a = new Shell(paramShell, 34912);
    this.a.setLayout(new GridLayout());
  }

  private void a(Text paramText)
  {
    paramText.addModifyListener(new b(this, paramText));
  }

  private void e()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayoutData(new GridData(64));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 2;
    localComposite.setLayout(localGridLayout);
    Button localButton1 = new Button(localComposite, 8);
    localButton1.setText(d.getString("OK"));
    localButton1.addSelectionListener(new c(this));
    Button localButton2 = new Button(localComposite, 8);
    localButton2.setText(d.getString("Cancel"));
    localButton2.addSelectionListener(new d(this));
    this.a.setDefaultButton(localButton1);
  }

  private void f()
  {
    if (this.c == null)
      return;
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayoutData(new GridData(768));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 2;
    localComposite.setLayout(localGridLayout);
    if (this.b == null)
      this.b = new String[this.c.length];
    for (int i = 0; i < this.c.length; i++)
    {
      Label localLabel = new Label(localComposite, 131072);
      localLabel.setText(this.c[i]);
      Text localText = new Text(localComposite, 2048);
      GridData localGridData = new GridData();
      localGridData.widthHint = 400;
      localText.setLayoutData(localGridData);
      if (this.b[i] != null)
        localText.setText(this.b[i]);
      localText.setData("index", new Integer(i));
      a(localText);
    }
  }

  public String[] a()
  {
    return this.c;
  }

  public String b()
  {
    return this.a.getText();
  }

  public String[] c()
  {
    return this.b;
  }

  public String[] d()
  {
    f();
    e();
    this.a.pack();
    this.a.open();
    Display localDisplay = this.a.getDisplay();
    while (!this.a.isDisposed())
    {
      if (localDisplay.readAndDispatch())
        continue;
      localDisplay.sleep();
    }
    return c();
  }

  public void a(String[] paramArrayOfString)
  {
    this.c = paramArrayOfString;
  }

  public void a(String paramString)
  {
    this.a.setText(paramString);
  }

  public void b(String[] paramArrayOfString)
  {
    if (this.c == null)
      return;
    if (this.b == null)
      this.b = new String[this.c.length];
    int i = Math.min(this.b.length, paramArrayOfString.length);
    for (int j = 0; j < i; j++)
      this.b[j] = paramArrayOfString[j];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.a
 * JD-Core Version:    0.6.0
 */