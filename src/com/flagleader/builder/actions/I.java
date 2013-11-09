package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bq;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElementViewer;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class I extends h
{
  public I(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()) && ((localControl instanceof StyledText)))
    {
      ((StyledText)localControl).print();
      return;
    }
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && ((localIElementViewer instanceof bq)))
      try
      {
        PrintDialog localPrintDialog = new PrintDialog(ActionsManager.a(this.a).getShell(), 0);
        PrinterData localPrinterData = localPrintDialog.open();
        if (localPrinterData == null)
          return;
        Printer localPrinter = new Printer(localPrinterData);
        ((bq)ActionsManager.a(this.a).getRuleEditor().e()).a(localPrinter);
        localPrinter.dispose();
      }
      catch (SWTError localSWTError)
      {
        ActionsManager.a(this.a).showError(c.b("Printing_error") + localSWTError.getMessage());
      }
  }

  public boolean isEnabled()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()) && ((localControl instanceof StyledText)))
      return true;
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    return (localIElementViewer instanceof bq);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.I
 * JD-Core Version:    0.6.0
 */