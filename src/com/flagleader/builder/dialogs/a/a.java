package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.dialogs.r;
import com.flagleader.repository.rom.IBusinessObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class a extends r
{
  private String a;
  private String b;
  private Text c;
  private Text d;

  public a(Shell paramShell, IBusinessObject paramIBusinessObject)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddArrayElementDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(300, 100));
    a(localComposite2).setText(a("index.AddArrayElementDialog"));
    this.c = a(localComposite2, 2048, 200, 12);
    a(localComposite2).setText(a("disElement.AddArrayElementDialog"));
    this.d = a(localComposite2, 2048, 200, 12);
    return localComposite1;
  }

  protected void okPressed()
  {
    this.a = this.c.getText();
    this.b = this.d.getText();
    if ((this.a.length() > 0) && (this.b.length() > 0))
      try
      {
        Integer.parseInt(this.a);
        super.okPressed();
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.a
 * JD-Core Version:    0.6.0
 */