// Have inserted "export" before initial "let TPyParser" in the following module:
import { TPyParser} from "./tigerpython-parser-opt.js";

const runTigerPython = async (filenames: Array<string>) => {
    await Promise.all(filenames.map(async (filename) => {
        const codeText = await Deno.readTextFile(filename);
        const tpErrors = TPyParser.findAllErrors(codeText);

        tpErrors.forEach((e: any) => {
            const record = {
                filename,
                line: e.line,
                messageCode: e.code,
                messageText: e.msg,
            };
            console.log(JSON.stringify(record));
        });
    }));
};

await runTigerPython(Deno.args);
